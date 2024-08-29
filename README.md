# Dice Roll - Intro to Android App Development

Cal Poly Humboldt CS Club - 8/29/24

## 🔑 Key Points 🔑

    0. Download zip file from GitHub
    1. Working with Android Studio
    2. Planning out your app's UI
    3. App Functionality - Intro to Kotlin



## 💻 Working with Android Studio

* Locate files in the **Project tab**

> `MainActivity.kt` is the starting point of the app and is located in app > kotlin+java > com.example.dicerolldemo
> The `res` folder includes the `drawable` folder where you'll find the dice images for the app

* Code and split preview windows

* **Device Manager** - add an emulator or your own device
> Click \+ and then "Create Virtual Device"

* To put your phone in developer mode
> Settings > About phone > Software information > Build number (tap it 8 times). Go back and you'll have Developer options
> You can try wireless debugging or wired. You can also mirror your phone in the Running Devices window


## 📐 Planning out your app's UI

* Consider the necessary elements and their arrangement with one another. We have a picture, a button, and then some text. 

* Let's add them in one by one.  

> ✨Jetpack Compose is a framework made by Google to help you build Android apps. It uses composable functions that describe a piece of the UI (user interface), like a Button or Text. They can have inputs, such as a String of text to be displayed, but they don't return anything. 

### ✅ Code for the dice image
```kotlin
Image(
    painter = painterResource(id = R.drawable.dice1),
    contentDescription = "dice image"
)
```
### ✅ Code for the button
```kotlin
Button(onClick = { /* TODO */ }) { 
    Text(text = "Roll the dice!")
}
```

### ✅ Code for the text
```kotlin
Text(text = "You rolled a 1")
```

> Without any container to hold and align them, they will just be bunched up in the top corner.

* Can you break it down into `Row`, `Column`, and/or `Box`? You can make this app into a column with the elements center aligned

> These are the three common building blocks you will use to arrange and align items. You can nest them within each other too.

### ✅ Place it all in a Column
```kotlin
Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Image()
        Button()
        Text()
    }
```

### Now that we have the basic layout set up, let's work on the functionality

## 📌 App functionality - Intro to Kotlin

**Functional requirements:** When the user taps the button, a random number between 1-6 should appear at the bottom, and the corresponding dice picture appears.

We'll need an int variable to keep track of the current roll

> In Kotlin, use `var` if you need a variable that can be reassigned and `val` if the value isn't going to change. Our number is changing each roll so we need a `var`. We are dealing with state and displaying information on the screen, so we do it this way.

### ✅ Using a var by remember
```kotlin
var roll by remember { mutableIntStateOf(1) }
```

> 1 is the placeholder default

Now replace the `Text(text = "You rolled a 1")` with `Text(text = "You rolled a $roll")`

Now we can use that `roll` to get the corresponding picture. In Java or C++ you might use a switch. But this is Kotlin so we are using `when`.

### ✅ Using a `when`

```kotlin
val diceImage = when (roll) {
    1 -> R.drawable.dice1
    2 -> R.drawable.dice2
    3 -> R.drawable.dice3
    4 -> R.drawable.dice4
    5 -> R.drawable.dice5
    6 -> R.drawable.dice6
    else -> R.drawable.dice1
}
```

Now replace the default image with `diceImage` in the `Image` composable.

We have a variable for the roll and a way to get the image, but we haven't made the number randomly generate. We can do this with the button. When the button is tapped, generate the random number

### ✅ Setting the button onClick to generate a random number
```kotlin
Button(onClick = { roll = (1..6).random() }) {
    Text(text = "Roll the dice!")
}
```

## Recap and More
Concepts used for this app:

* `var` and `val`

* `when` 

* `random` 

* Composables used: `Column`, `Button`, `Text`, `Image`

Layouts in Compose: https://developer.android.com/develop/ui/compose/layouts/basics

Styling text: https://developer.android.com/develop/ui/compose/text/style-text

To learn more about Android development:
https://developer.android.com/courses/android-basics-compose/course







