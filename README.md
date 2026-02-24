# Summary 
Built using Android Studio and Kotlin, this project displays Settings screen using Jetpack Compose and Material 3. The main layout uses a Column as the overall container, and each individual setting is built as a Row with a Column on the left (for the title and description) and a control like a Switch, Checkbox, or Slider on the right. I used Modifier.weight(1f) inside each row to keep the controls aligned and prevent the text from being cut off, which was something we practiced in the Row/Column in-class example. I grouped settings into sections (Account, Connections, Display, Accessibility) using a custom SectionCard to make the UI look more structured and realistic. I also added scrolling so the screen works in landscape mode, and I used rememberSaveable to make sure state persists when the device rotates.

# Screenshots of the Running App

# Details
- Emulator: Medium Phone API 36.1
- SDK Version: Android 16.0 ("Baklava") API Level 36.0

# AI Disclosure

AI was used as a support tool during development, primarily to help troubleshoot layout issues and confirm best practices. For example, I used AI to help understand why Modifier.weight(1f) only works inside a RowScope, and to fix an error related to weight being used incorrectly. AI also helped explain the difference between remember and rememberSaveable, which I then implemented so that toggle states would persist across screen orientation changes. Additionally, AI provided guidance on replacing deprecated Divider() with the newer HorizontalDivider() API.
However, the overall structure and features of the screen were based on the in-class Row and Column example. I reused and adapted patterns we practiced in class, such as nesting Row and Column, spacing with Spacer, and grouping elements visually. I experimented with several layout variations myself (including versions without descriptions and without section grouping) before finalizing the current design. AI was used mainly for clarification and debugging rather than generating the full implementation.
