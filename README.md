# Summary 
Built using Android Studio and Kotlin, this project displays Settings screen using Jetpack Compose and Material 3. The main layout uses a Column as the overall container, and each individual setting is built as a Row with a Column on the left (for the title and description) and a control like a Switch, Checkbox, or Slider on the right. I used Modifier.weight(1f) inside each row to keep the controls aligned and prevent the text from being cut off, which was something we practiced in the Row/Column in-class example. I grouped settings into sections (Account, Connections, Display, Accessibility) using a custom SectionCard to make the UI look more structured and realistic. I also added scrolling so the screen works in landscape mode, and I used rememberSaveable to make sure state persists when the device rotates.

# Screenshots of the Running App
<img width="180" height="400" alt="Screenshot_20260224_120236" src="https://github.com/user-attachments/assets/47a69eb2-8763-408e-8426-80695426b0b5" />
<img width="180" height="400" alt="Screenshot_20260224_120257" src="https://github.com/user-attachments/assets/71756a94-d59a-4a06-b29e-722f899ca3bd" />
<img width="400" height="180" alt="Screenshot_20260224_120308" src="https://github.com/user-attachments/assets/23f05452-4720-4368-bebe-396a34bc0565" />
<img width="400" height="180" alt="Screenshot_20260224_120320" src="https://github.com/user-attachments/assets/23e74c85-8908-4047-845c-c5274c7c9612" />
<img width="400" height="180" alt="Screenshot_20260224_120331" src="https://github.com/user-attachments/assets/d8f3ed38-dc55-4092-83fa-ff42688f5ac8" />


# Details
- Emulator: Medium Phone API 36.1
- SDK Version: Android 16.0 ("Baklava") API Level 36.0

# AI Disclosure

AI was used as a support tool during development, primarily to help troubleshoot layout issues and confirm best practices. For example, I used AI to help understand why Modifier.weight(1f) only works inside a RowScope, and to fix an error related to weight being used incorrectly. AI also helped explain the difference between remember and rememberSaveable, which I then implemented so that toggle states would persist across screen orientation changes. Additionally, AI provided guidance on replacing deprecated Divider() with the newer HorizontalDivider() API.
However, the overall structure and features of the screen were based on the in-class Row and Column example. I reused and adapted patterns we practiced in class, such as nesting Row and Column, spacing with Spacer, and grouping elements visually. I experimented with several layout variations myself (including versions without descriptions and without section grouping) before finalizing the current design. AI was used mainly for clarification and debugging rather than generating the full implementation.
