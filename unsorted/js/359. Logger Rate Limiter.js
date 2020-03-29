/**
 * Initialize your data structure here.
 */
var Logger = function () {
	this.map = new Map();
};

/**
 * Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. 
 * @param {number} timestamp 
 * @param {string} message
 * @return {boolean}
 */
Logger.prototype.shouldPrintMessage = function (timestamp, message) {
	// console.log("map", this.map);
	if (!this.map.has(message)) {
		// should not be like this:
		// this.map.message = timestamp + 10;
		this.map.set(message, timestamp + 10);
		return true;
	}
	else {
		// get,set instead of .: could be []
		if (timestamp >= this.map.get(message)) {
			this.map.set(message, timestamp + 10);
			return true;
		}
		else {
			return false;
		}
	}
};

/** 
 * Your Logger object will be instantiated and called as such:
 * var obj = new Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */
