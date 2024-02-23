package com.stackcodie.chatApp.chat;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

	private final ChatMessageRepository repository;

    public ChatMessage save(ChatMessage chatMessage) {
    	chatMessage.setChatId(generateChatId(chatMessage.getSenderId(), chatMessage.getRecipientId()));
        repository.save(chatMessage);
        return chatMessage;
    }

    private String generateChatId(String senderId, String recipientId) {
    	return senderId + "_" + recipientId;
    	}

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        String chatId = generateChatId(senderId, recipientId);
        return repository.findByChatId(chatId);
    }
}
