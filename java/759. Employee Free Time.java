/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> total = new ArrayList<>();
        for (List<Interval> list : schedule) {
            total.addAll(list);
        }

        total.sort((i1, i2) -> {
            if (i1.start != i2.start)
                return i1.start - i2.start;
            else {
                return i1.end - i2.end;
            }
        });
        // ??
        if (total.size() <= 1) {
            return total;
        }
        Interval pre = total.get(0);
        List<Interval> freeTime = new ArrayList<Interval>();
        for (int i = 1; i < total.size(); i++) {
            Interval cur = total.get(i);
            if (cur.start > pre.end) {
                freeTime.add(new Interval(pre.end, cur.start));
                pre = cur;
            } else {
                if (cur.end > pre.end)
                    pre.end = cur.end;
            }
        }
        return freeTime;

    }
}