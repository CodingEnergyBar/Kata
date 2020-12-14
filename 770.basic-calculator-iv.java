/*
 * @lc app=leetcode id=770 lang=java
 *
 * [770] Basic Calculator IV
 */

// @lc code=start
class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        LinkedList<Expr> mainStack = new LinkedList();// 存数字，变量
        LinkedList<String> opStack = new LinkedList<>();// 存符号
        int i = 0, len = expression.length();
        char[] str = expression.toCharArray();
        while (i < len) {
            if (Character.isDigit(str[i])) { // 获取数字
                int x = 0;
                while (i < len && Character.isDigit(str[i])) {
                    x = 10 * x + str[i] - '0';
                    i++;
                } // 统计数字的常用模板
                mainStack.push(new Expr(new Item(x)));
            } else if (str[i] >= 'a' && str[i] <= 'z') {
                StringBuilder sb = new StringBuilder();
                while (i < len && (str[i] >= 'a' && str[i] <= 'z')) {
                    sb.append(str[i]);
                    i++;
                }
                String s = sb.toString();
                if (map.containsKey(s))// 如果该变量有值
                { // 变量变数字
                    mainStack.push(new Expr(new Item(map.get(s))));
                } else {
                    // 创建变量多项式
                    mainStack.push(new Expr(new Item(1, s)));
                }
                // 左括号直接入栈
            } else if (str[i] == '(') {
                opStack.push("(");
                i++;
            } else if (str[i] == ')') {
                // 遇到有括号，则不停出栈，运算，直到遇到左括号为止
                while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                    String op = opStack.pop();
                    Expr expr2 = mainStack.pop();
                    Expr expr1 = mainStack.pop();
                    mainStack.push(expr1.operate(expr2, op));
                }
                opStack.pop();
                i++;// 左括号出栈，指针移动
            } else if (str[i] == '*') {
                while (!opStack.isEmpty() && opStack.peek().equals("*")) {
                    // 如果栈顶为乘号，先计算乘号，把乘法处理完
                    String op = opStack.pop();
                    Expr expr2 = mainStack.pop();
                    Expr expr1 = mainStack.pop();
                    mainStack.push(expr1.operate(expr2, op));
                }
                opStack.push("*");
                i++;// 再入栈
            } else { // 把前驱的加减号处理完
                while (!opStack.isEmpty()
                        && (opStack.peek().equals("+") || opStack.peek().equals("-") || opStack.peek().equals("*"))) {
                    String op = opStack.pop();
                    Expr expr2 = mainStack.pop();
                    Expr expr1 = mainStack.pop();
                    mainStack.push(expr1.operate(expr2, op));
                }
                opStack.push(str[i] == '+' ? "+" : "-");
                i++;
            }
        }
        while (!opStack.isEmpty()) { // 处理后缀表达式
            String op = opStack.pop();
            Expr expr2 = mainStack.pop();
            Expr expr1 = mainStack.pop();
            mainStack.push(expr1.operate(expr2, op));
        }
        List<String> res = new ArrayList<>();
        Expr expr = mainStack.pop();
        expr.clean();
        for (Item item : expr.items)
            res.add(item.toString());
        return res;

    }
}

// 单项式
class Item implements Comparable<Item> {
    int coeff; // 单项式系数
    ArrayList<String> factors;// 单项式字母

    public Item(int coeff) {
        this.coeff = coeff;
        factors = new ArrayList<>();
    }

    public Item() {
        this.factors = new ArrayList<>();
        coeff = 0;
    }

    public Item(int coeff, String f) {
        this.coeff = coeff;
        this.factors = new ArrayList<>();
        factors.add(f);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(coeff);
        for (String s : factors) {
            sb.append("*").append(s);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Item item) {
        if (this.factors.size() == item.factors.size())// 如果两个单项式字母长度相等
        {
            int i = 0, len = this.factors.size();// 按照字典顺序比较
            while (i < len && factors.get(i).compareTo(item.factors.get(i)) == 0)
                i++;
            return i == len ? 0 : factors.get(i).compareTo(item.factors.get(i));
        } else {
            // 按长度从大到小排位
            return item.factors.size() - factors.size();

        }
    }

    // 单项式相乘
    Item mutil(Item item) {
        Item res = new Item();
        res.coeff = coeff * item.coeff;// 乘系数
        res.factors.addAll(factors);
        res.factors.addAll(item.factors); // 合并字母
        res.factors.sort(String::compareTo);// 排序
        return res;
    }
}

// 多项式：由多个单项式组成
class Expr {
    ArrayList<Item> items; // 单项式列表

    public Expr(Item item) {
        this.items = new ArrayList<>();
        items.add(item);
    }

    void add(Expr expr) { // 将另外多项式的项直接合并过来
        items.addAll(expr.items);
        items.sort(Item::compareTo);// 排序
        clean();// 去除冗余项
    }

    void mul(Expr expr) {
        ArrayList<Item> res = new ArrayList<>();
        for (Item item1 : items)
            for (Item item2 : expr.items)
                res.add(item1.mutil(item2)); // 将每一项按乘法规则相乘
        this.items = res;
        items.sort(Item::compareTo);
        clean();
    }

    Expr clean() { // 去除冗余同项
        int i = 0;
        for (; i < items.size(); i++) {
            // 对于每个单项式，比较前后两个
            while (i + 1 < items.size() && items.get(i).compareTo(items.get(i + 1)) == 0) {
                // 如果前后两个单项式字母相等，则合并，并删除靠后的一个
                items.get(i).coeff += items.get(i + 1).coeff;
                items.remove(i + 1);
            }
            // 如果单项式系数=0 删除该项
            if (i < items.size() && items.get(i).coeff == 0)
                items.remove(i--);
        }
        return this;
    }

    Expr operate(Expr expr, String op) {
        switch (op) {
            case "*":
                mul(expr);
                break;
            case "+":
                add(expr);
                break;
            case "-":
                for (Item item : expr.items)
                    item.coeff *= -1;
                add(expr);
                ;
                break;
        }
        return this;
    }
}
// @lc code=end
