// src/main/resources/static/chat.js
let stompClient = null;
function connect() {
    const socket = new SockJS('/ws-chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, () => {
        stompClient.subscribe('/topic/messages', (message) => {
            const msg = JSON.parse(message.body);
            showMessage(msg);
        });
    });
}

function sendMessage() {
    const input = document.getElementById('message');
    const text = input.value.trim();
    if (text) {
        stompClient.send("/app/sendMessage", {}, JSON.stringify({
            sender: "Você",
            content: text,
            type: "user"
        }));
        input.value = '';
    }
}

function showMessage(msg) {
    const chat = document.getElementById('chat');
    const bubble = document.createElement('div');
    bubble.className = msg.type === 'ai' ? 'text-green-400 mb-2' : 'text-blue-400 mb-2';
    bubble.innerText = msg.sender + ": " + msg.content;
    chat.appendChild(bubble);
    chat.scrollTop = chat.scrollHeight;
}

connect();
