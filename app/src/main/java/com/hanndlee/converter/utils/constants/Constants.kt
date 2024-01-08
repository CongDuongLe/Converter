package com.hanndlee.converter.utils.constants

data class CoffeeItem(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int,
    val isFavorite: Boolean = false,
    val description: String,
    val sugar: Int,
    val milk: Int,
    val size: String,
    val ice: Int,
    )

var listCoffee = listOf<CoffeeItem>(
        CoffeeItem(
            id = 1,
            name = "Cappuccino",
            price = 5,
            image = 1,
            isFavorite = false,
            description = "Cappuccino is a coffee drink that today is composed of a double espresso and hot milk, with the surface topped with foamed milk.",
            sugar = 0,
            milk = 0,
            size = "M",
            ice = 0,
        ),
        CoffeeItem(
            id = 2,
            name = "Espresso",
            price = 5,
            image = 2,
            isFavorite = false,
            description = "Espresso is a coffee-brewing method of Italian origin, in which a small amount of nearly boiling water is forced under pressure through finely-ground coffee beans.",
            sugar = 0,
            milk = 0,
            size = "M",
            ice = 0,
        ),
        CoffeeItem(
            id = 3,
            name = "Latte",
            price = 5,
            image = 3,
            isFavorite = false,
            description = "Caffè latte is a coffee drink made with espresso and steamed milk. The word comes from the Italian caffè e latte, caffelatte or caffellatte, which means 'coffee & milk'.",
            sugar = 0,
            milk = 0,
            size = "M",
            ice = 0,
        ),
        CoffeeItem(
            id = 4,
            name = "Mocha",
            price = 5,
            image = 4,
            isFavorite = false,
            description = "A caffè mocha, also called mocaccino, is a chocolate-flavoured variant of a caffè latte. Other commonly used spellings are mochaccino and also mochachino.",
            sugar = 0,
            milk = 0,
            size = "M",
            ice = 0,
        ),
        CoffeeItem(
            id = 5,
            name = "Americano",
            price = 5,
            image = 5,
            isFavorite = false,
            description = "Caffè Americano or Americano is a type of coffee drink prepared by diluting an espresso with hot water, giving it a similar strength to, but different flavor from, traditionally brewed coffee.",
            sugar = 0,
            milk = 0,
            size = "M",
            ice = 0,
        ),
        CoffeeItem(
            id = 6,
            name = "Caramel Macchiato",
            price = 5,
            image = 6,
            isFavorite = false,
            description = "Caffè macchiato, sometimes called espresso macchiato, is an espresso coffee drink with a small amount of milk, usually foamed.",
            sugar = 25,
            milk = 50,
            size = "S",
            ice = 25,
        ),
        CoffeeItem(
            id = 7,
            name = "Caramel Frappuccino",
            price = 5,
            image = 7,
            isFavorite = false,
            description = "Frappuccino is a trademarked brand of the Starbucks Corporation for a line of iced, blended coffee drinks. It consists of coffee or crème base, blended with ice and other various ingredients, usually topped with whipped cream and flavored syrups.",
            sugar = 50,
            milk = 25,
            size = "L",
            ice = 50,
        ),
        CoffeeItem(
            id = 8,
            name = "Caramel Latte",
            price = 5,
            image = 8,
            isFavorite = false,
            description = "Caffè latte is a coffee drink made with espresso and steamed milk. The word comes from the Italian caffè e latte, caffelatte or caffellatte, which means 'coffee & milk'.",
            sugar = 50,
            milk = 0,
            size = "XL",
            ice = 25,
        )

    )