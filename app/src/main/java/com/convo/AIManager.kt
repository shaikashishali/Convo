package com.convo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AIManager {

    // Simulate generating an AI response; replace integration with actual on-device model or online API.
    suspend fun generateResponse(prompt: String, offline: Boolean = true): String {
        return withContext(Dispatchers.Default) {
            if (offline) {
                // Simple deterministic stub: echo + small transformation
                "🤖 (offline) I heard: ${'$'}{prompt.take(300)}"
            } else {
                // Placeholder for online API call
                "🤖 (online) Response to: ${'$'}{prompt.take(300)}"
            }
        }
    }
}
