package com.example.imageswipe

import java.net.URL

class Gallery {

    val urls: List<URL> = listOf(
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/ferrari.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/red-bull-racing.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/mercedes.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/mclaren.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/alfa-romeo.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/alpine.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/alphatauri.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/haas-f1-team.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/aston-martin.png.transform/6col/image.png"),
        URL("https://www.formula1.com/content/dam/fom-website/teams/2022/williams.png.transform/6col/image.png"))

    val descriptions: List<String> = listOf(
        "Ferrari",
        "Red Bull",
        "Mercedes",
        "McLaren",
        "Alfa Romeo",
        "Alpine",
        "Alpha Tauri",
        "Haas",
        "Aston Martin",
        "Williams")
}