# ComposeProgressItem


## Setup
```gradle
repositories {
    ...
    maven { url "https://jitpack.io" }
}

dependencies {
    ...
    implementation "com.github.Hyuck9:ComposeProgressItem:0.0.1"
}
```

## How to use
```kotlin
ProgressItem(
    modifier = Modifier
        .padding(vertical = 16.dp)
        .fillMaxWidth()
        .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
        .clip(RoundedCornerShape(10.dp))
        .background(Color(0xfff9f2ff)),
    brush = Brush.horizontalGradient(listOf(Color(0xff86f7fa), Color(0xff9b86fa))), // progress foreground. [color or brush]
    percent = 60f,  // progress percent
) {
    // Your UI Area
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Test title",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Test content bla bla",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
    }
}
```