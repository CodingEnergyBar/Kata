function fiboEvenSum(n) {
	if (n === 1) return 0;
	if (n === 2) return 2;
	let fib = [ 1, 2 ];

	let i = 2;
	while (i <= n) {
		// i -> n-1
		fib[i] = fib[i - 1] + fib[i - 2];
		i++;
	}
	let evenSum = 0;
	for (let j = 0; j <= n; j++) {
		evenSum += fib[j] % 2 === 0 ? fib[j] : 0;
	}
	return evenSum;
}

fiboEvenSum(10);
