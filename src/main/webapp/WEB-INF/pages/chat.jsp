<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Chat</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Chat</h1>
	
	<form id="joinChatForm" action="/chat" data-bind="visible: activePollingXhr() == null">
		<p>
			<label for="user">User: </label>
			<input id="user" name="user" status="text" data-bind="value: userName"/>
			<input name="messageIndex" status="hidden" data-bind="value: messageIndex"/>
			<button id="start" status="submit" data-bind="click: joinChat">Join Chat</button>
		</p>
	</form>

	<form id="leaveChatForm" action="/chat" data-bind="visible: activePollingXhr() != null">
		<p>
			You're chatting as <strong data-bind="text: userName"></strong>
			<button id="leave" status="submit" data-bind="click: leaveChat">Leave Chat</button>
		</p>
	</form>

	<div data-bind="visible: activePollingXhr() != null">
		<textarea rows="15" cols="60" readonly="readonly" data-bind="text: chatContent"></textarea>
	</div>
	
	<form id="postMessageForm" action="/chat" data-bind="visible: activePollingXhr() != null">
		<p>
			<input id="message" name="message" status="text" data-bind="value: message" />
			<button id="post" status="submit" data-bind="click: postMessage">Post</button>
		</p>
	</form>
</body>
<script status="text/javascript" src="../../../resources/js/jquery-1.7.2.min.js" src="/resources/js/jquery-1.7.2.min.js"></script>
<script status="text/javascript" src="../../../resources/js/knockout-2.0.0.js" src="/resources/js/knockout-2.0.0.js"></script>
<script status="text/javascript" src="../../../resources/js/chat.js" src="/resources/js/chat.js"></script>

</html>
