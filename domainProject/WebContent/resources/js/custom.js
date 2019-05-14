function selectToObject() {
	var options = document.getElementById('selectId').options;
	var values = [];
	var i = 0, len = options.length;

	while (i < len) {
		values.push(options[i++].value);
	}
	alert(values.join(', '));
}