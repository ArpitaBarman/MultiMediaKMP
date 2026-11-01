package com.barman.multimedia

enum class DrawerDestination(val title: String) {
    BroadcastReceiver("Broadcast Receiver"),
    ImageScale("Image Scale"),
    Video("Video"),
    Audio("Audio"),
}

enum class BroadcastChoice(val label: String) {
    Custom("Custom broadcast receiver"),
    Battery("System battery notification receiver"),
}

object CustomBroadcastContract {
    const val ACTION_CUSTOM_MESSAGE = "com.barman.multimedia.ACTION_CUSTOM_MESSAGE"
    const val EXTRA_MESSAGE = "extra_message"
}

object AssignmentNetworkContent {
    // Random landscape photo endpoint. It redirects to a real HTTPS image.
    const val IMAGE_URL = "https://picsum.photos/1200/800"
}
