db.persons.insertMany([
    {
        "name": "dave",
        "pets": [ 111, 112, 113],
        "posts": [
            { "postId": 1, "postViews": 10 },
            { "postId": 2, "postViews": 5 }
        ],
        "totalViews": 100,
        "address": { "addressLine1": "10 Main Str", "city": "Toronto", "postcode": "M2H 2Y2" }
    },
    {
        "name": "smith",
        "pets": [ 111, 112 ],
        "totalViews": 521,
        "address": { "addressLine1": "20 Main Str", "city": "Markham", "postcode": "L2H 2Y2" }
    },
    {
        "name": "ahn",
        "pets": [ 111, 112, 113 ],
        "posts": [
            { "postId": 1, "postViews": 20 },
            { "postId": 2, "postViews": 15 }
        ],
        "totalViews": 100,
        "address": { "addressLine1": "30 Main Str", "city": "Richmond Hill", "postcode": "L3C 2Y2" }
    },
    {
        "name": "li",
        "pets": [ 111 ],
        "totalViews": 5000,
        "address": { "addressLine1": "40 Main Str", "city": "Markham", "postcode": "L2H 2Y2" }
    },
    {
        "name": "annT",
        "pets": [ 112, 113 ],
        "posts": [
            { "postId": 1, "postViews": 10 },
        ],
        "totalViews": 100
    },
    {
        "name": "li",
        "pets": [ 112 ],
        "posts": [
            { "postId": 1, "postViews": 10 },
            { "postId": 2, "postViews": 5 },
            { "postId": 3, "postViews": 15 },
            { "postId": 4, "postViews": 25 }
        ],
        "totalViews": 100,
        "address": { "addressLine1": "50 Main Str", "city": "Ajax", "postcode": "M9H 2Y2" }
    },
    {
        "name": "ty",
        "pets": [ 113 ],
        "totalViews": 1000,
        "address": { "addressLine1": "60 Main Str", "city": "Toronto", "postcode": "M2H 2Y2" }
    }
]);

db.pets.insertMany([
    {"petId": 111, "petName": "dog",    "petFood": "Meat"},
    {"petId": 112, "petName": "rabbit", "petFood": "carrot"},
    {"petId": 114, "petName": "cat",    "petFood": "Fish"},
    {"petId": 115, "petName": "fish",   "petFood": "worm"}
])


