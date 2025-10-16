# 🧠 Real-Time AI Chat (Spring Boot + WebSocket)

A real-time chat web application powered by **Spring Boot 3.5.6**, **WebSockets (STOMP)**, and **OpenAI’s ChatGPT API**.  
This project lets users send messages in a live chat interface and receive intelligent responses from an AI assistant — instantly.

---

## ⚙️ Tech Stack

| Layer | Technology |
|--------|-------------|
| Backend | Java 21 · Spring Boot 3.5.6 |
| Realtime | WebSocket (STOMP over SockJS) |
| AI Integration | OpenAI Chat Completions API |
| Frontend | HTML · TailwindCSS · JavaScript |
| Build Tool | Maven 3.9+ |
| Deployment | JAR (self-contained) |

---

## 🏗️ Features

✅ Real-time, two-way chat (WebSocket + STOMP)  
✅ OpenAI integration for intelligent responses  
✅ TailwindCSS UI with dark mode theme  
✅ No page reloads — all dynamic updates  
✅ Simple local authentication (optional)  
✅ Easily extendable for JWT or database logging  

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/realtime-ai-chat.git
cd realtime-ai-chat

### 2. Configure OpenAI API Key

Edit src/main/resources/application.yml:
  openai:
  api:
    key: ${OPENAI_API_KEY}

Then set your environment variable:

macOS / Linux:
export OPENAI_API_KEY="sk-proj-your-new-key-here"

Windows:
setx OPENAI_API_KEY "sk-proj-your-new-key-here"

### 3. Run the Application
mvn spring-boot:run



Once started, visit:

👉 http://localhost:8080

### Project Structure:
src/
 ├── main/
 │    ├── java/com/grimoire/chat/
 │    │    ├── ChatApplication.java
 │    │    ├── ChatController.java
 │    │    ├── ChatService.java
 │    │    ├── ChatMessage.java
 │    │    ├── WebSocketConfig.java
 │    │    └── SecurityConfig.java
 │    └── resources/
 │         ├── static/
 │         │    ├── index.html
 │         │    ├── chat.js
 │         │    └── style.css
 │         └── application.yml
 └── test/

