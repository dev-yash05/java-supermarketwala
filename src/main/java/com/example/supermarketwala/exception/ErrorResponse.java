package com.example.supermarketwala.exception;

public record ErrorResponse(String timestamp,
		int status,
		String error,
		String message,
		String path
		) {}
