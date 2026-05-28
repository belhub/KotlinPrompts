package shared.data

import shared.models.Recipe
import shared.models.RecipeType
import shared.models.Ingredient

val recipesMock = listOf(
    Recipe(
        id = "1",
        name = "Tosty z awokado i jajkiem",
        prepTime = 15,
        servings = 2,
        type = RecipeType.Śniadanie,
        image = "https://images.unsplash.com/photo-1525351484163-7529414344d8?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Pieczywo pełnoziarniste", "2 kromki"),
            Ingredient("Awokado", "1 szt."),
            Ingredient("Jajka", "2 szt."),
            Ingredient("Sok z cytryny", "1 łyżeczka")
        ),
        steps = listOf(
            "Zgnieć awokado z sokiem z cytryny i odrobiną soli.",
            "Usmaż jajka sadzone na średnim ogniu.",
            "Podpiecz pieczywo i posmaruj je pastą z awokado.",
            "Ułóż jajko na wierzchu i podawaj od razu."
        )
    ),
    Recipe(
        id = "2",
        name = "Kremowy makaron z kurczakiem",
        prepTime = 30,
        servings = 3,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1525518392674-39ba1a9f8f24?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Makaron penne", "250 g"),
            Ingredient("Pierś z kurczaka", "300 g"),
            Ingredient("Śmietanka 18%", "150 ml"),
            Ingredient("Szpinak", "2 garście")
        ),
        steps = listOf(
            "Ugotuj makaron al dente według instrukcji na opakowaniu.",
            "Podsmaż kurczaka na złoto i dopraw solą oraz pieprzem.",
            "Dodaj śmietankę, szpinak i wymieszaj z makaronem.",
            "Podawaj z odrobiną parmezanu."
        )
    ),
    Recipe(
        id = "3",
        name = "Sałatka z pieczonymi warzywami",
        prepTime = 25,
        servings = 2,
        type = RecipeType.Kolacja,
        image = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Mix sałat", "1 opak."),
            Ingredient("Papryka", "1 szt."),
            Ingredient("Cukinia", "1/2 szt."),
            Ingredient("Ser feta", "80 g")
        ),
        steps = listOf(
            "Warzywa pokrój, skrop oliwą i upiecz do miękkości.",
            "Przełóż sałatę do miski i dodaj warzywa.",
            "Posyp fetą oraz ulubionymi pestkami.",
            "Polej lekkim dressingiem cytrynowym."
        )
    ),
    Recipe(
        id = "4",
        name = "Jogurtowy deser z owocami",
        prepTime = 10,
        servings = 2,
        type = RecipeType.Deser,
        image = "https://images.unsplash.com/photo-1488477181946-6428a0291777?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Jogurt grecki", "200 g"),
            Ingredient("Owoce sezonowe", "1 miseczka"),
            Ingredient("Miód", "1 łyżka"),
            Ingredient("Granola", "3 łyżki")
        ),
        steps = listOf(
            "Na dno szklanek nałóż jogurt.",
            "Dodaj owoce i odrobinę miodu.",
            "Posyp granolą przed podaniem."
        )
    ),
    Recipe(
        id = "5",
        name = "Smoothie truskawkowo-bananowe",
        prepTime = 5,
        servings = 1,
        type = RecipeType.Śniadanie,
        image = "https://images.unsplash.com/photo-1497534446932-c925b458314e?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Truskawki", "1 szklanka"),
            Ingredient("Banan", "1 szt."),
            Ingredient("Jogurt naturalny", "150 ml"),
            Ingredient("Miód", "1 łyżeczka")
        ),
        steps = listOf(
            "Wrzuć wszystkie składniki do blendera.",
            "Zmiksuj na gładkie smoothie.",
            "Podawaj od razu, najlepiej schłodzone."
        )
    ),
    Recipe(
        id = "6",
        name = "Kurczak teriyaki z ryżem",
        prepTime = 35,
        servings = 2,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1604908177522-040a9f4a6f3b?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Pierś z kurczaka", "300 g"),
            Ingredient("Sos teriyaki", "4 łyżki"),
            Ingredient("Ryż jaśminowy", "150 g"),
            Ingredient("Brokuł", "1/2 szt.")
        ),
        steps = listOf(
            "Ugotuj ryż według instrukcji.",
            "Podsmaż kurczaka i dodaj sos teriyaki.",
            "Ugotuj brokuła na parze.",
            "Podawaj kurczaka z ryżem i brokułem."
        )
    ),
    Recipe(
        id = "7",
        name = "Placuszki bananowe",
        prepTime = 15,
        servings = 2,
        type = RecipeType.Śniadanie,
        image = "https://images.unsplash.com/photo-1587731556938-38755b4803a6?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Banany", "2 szt."),
            Ingredient("Jajka", "2 szt."),
            Ingredient("Mąka", "3 łyżki"),
            Ingredient("Olej", "1 łyżka")
        ),
        steps = listOf(
            "Rozgnieć banany i wymieszaj z jajkami.",
            "Dodaj mąkę i wymieszaj na jednolitą masę.",
            "Smaż małe placuszki na rozgrzanym oleju.",
            "Podawaj z owocami lub miodem."
        )
    ),
    Recipe(
        id = "8",
        name = "Tacos z wołowiną",
        prepTime = 25,
        servings = 3,
        type = RecipeType.Kolacja,
        image = "https://images.unsplash.com/photo-1601924582971-dc6c0f3f6f4b?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Tortille kukurydziane", "6 szt."),
            Ingredient("Mięso mielone wołowe", "300 g"),
            Ingredient("Pomidory", "2 szt."),
            Ingredient("Sałata", "1 garść")
        ),
        steps = listOf(
            "Podsmaż mięso i dopraw przyprawą do taco.",
            "Pokrój pomidory i sałatę.",
            "Podgrzej tortille na suchej patelni.",
            "Nadziewaj tortille mięsem i warzywami."
        )
    ),
    Recipe(
        id = "9",
        name = "Sałatka z łososiem i mango",
        prepTime = 20,
        servings = 2,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1550304943-4f24f54ddde9?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Łosoś wędzony", "150 g"),
            Ingredient("Mango", "1 szt."),
            Ingredient("Mix sałat", "2 garście"),
            Ingredient("Oliwa", "1 łyżka"),
            Ingredient("Sok z limonki", "1 łyżeczka")
        ),
                steps = listOf(
            "Pokrój mango i łososia w paski.",
            "Wymieszaj sałatę z oliwą i sokiem z limonki.",
            "Dodaj mango i łososia.",
            "Delikatnie wymieszaj i podawaj świeżo."
        )
    ),
    Recipe(
        id = "10",
        name = "Zupa krem z dyni",
        prepTime = 40,
        servings = 4,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1505253716362-afaea1d3d1af?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Dynia", "800 g"),
            Ingredient("Bulion warzywny", "1 l"),
            Ingredient("Cebula", "1 szt."),
            Ingredient("Śmietanka 30%", "50 ml")
        ),
        steps = listOf(
            "Podsmaż cebulę na maśle.",
            "Dodaj pokrojoną dynię i zalej bulionem.",
            "Gotuj do miękkości, a następnie zmiksuj.",
            "Dodaj śmietankę i dopraw solą oraz pieprzem."
        )
    ),
    Recipe(
        id = "11",
        name = "Owsianka z owocami",
        prepTime = 8,
        servings = 1,
        type = RecipeType.Śniadanie,
        image = "https://images.unsplash.com/photo-1506084868230-bb9d95c24759?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Płatki owsiane", "50 g"),
            Ingredient("Mleko", "200 ml"),
            Ingredient("Jagody", "1 garść"),
            Ingredient("Miód", "1 łyżeczka")
        ),
        steps = listOf(
            "Zagotuj mleko i dodaj płatki.",
            "Gotuj 3–4 minuty.",
            "Dodaj owoce i miód.",
            "Podawaj na ciepło."
        )
    ),
    Recipe(
        id = "12",
        name = "Burrito z kurczakiem",
        prepTime = 25,
        servings = 2,
        type = RecipeType.Kolacja,
        image = "https://images.unsplash.com/photo-1618213837799-25d1bbf3f5c1?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Tortilla pszenna", "2 szt."),
            Ingredient("Kurczak", "250 g"),
            Ingredient("Ryż", "100 g"),
            Ingredient("Fasola czerwona", "1/2 puszki")
        ),
        steps = listOf(
            "Ugotuj ryż.",
            "Podsmaż kurczaka z przyprawami.",
            "Dodaj fasolę i wymieszaj.",
            "Zawiń farsz w tortillę."
        )
    ),
    Recipe(
        id = "13",
        name = "Shakshuka",
        prepTime = 20,
        servings = 2,
        type = RecipeType.Śniadanie,
        image = "https://images.unsplash.com/photo-1604909052743-94e5c1a7109a?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Jajka", "3 szt."),
            Ingredient("Pomidory krojone", "1 puszka"),
            Ingredient("Papryka", "1 szt."),
            Ingredient("Czosnek", "2 ząbki")
        ),
        steps = listOf(
            "Podsmaż paprykę i czosnek.",
            "Dodaj pomidory i gotuj 5 minut.",
            "Wbij jajka i duś pod przykryciem.",
            "Podawaj z pieczywem."
        )
    ),
    Recipe(
        id = "14",
        name = "Sushi bowl",
        prepTime = 30,
        servings = 2,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1553621042-f6e147245754?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Ryż do sushi", "200 g"),
            Ingredient("Łosoś surowy", "150 g"),
            Ingredient("Ogórek", "1/2 szt."),
            Ingredient("Awokado", "1 szt.")
        ),
        steps = listOf(
            "Ugotuj ryż do sushi.",
            "Pokrój łososia, ogórka i awokado.",
            "Ułóż składniki w misce.",
            "Podawaj z sosem sojowym."
        )
    ),
    Recipe(
        id = "15",
        name = "Gnocchi w sosie pomidorowym",
        prepTime = 15,
        servings = 2,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1621996346565-016e0d8dfead?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Gnocchi", "300 g"),
            Ingredient("Sos pomidorowy", "200 ml"),
            Ingredient("Bazylia", "kilka listków"),
            Ingredient("Mozzarella", "80 g")
        ),
        steps = listOf(
            "Ugotuj gnocchi.",
            "Podgrzej sos pomidorowy.",
            "Wymieszaj gnocchi z sosem.",
            "Dodaj mozzarellę i bazylię."
        )
    ),
    Recipe(
        id = "16",
        name = "Tofu stir-fry",
        prepTime = 20,
        servings = 2,
        type = RecipeType.Kolacja,
        image = "https://images.unsplash.com/photo-1604909053191-3f3f94a639a6?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Tofu", "200 g"),
            Ingredient("Papryka", "1 szt."),
            Ingredient("Cukinia", "1/2 szt."),
            Ingredient("Sos sojowy", "2 łyżki")
        ),
        steps = listOf(
            "Podsmaż tofu na złoto.",
            "Dodaj pokrojone warzywa.",
            "Wlej sos sojowy i duś 5 minut.",
            "Podawaj z ryżem."
        )
    ),
    Recipe(
        id = "17",
        name = "Pancakes amerykańskie",
        prepTime = 15,
        servings = 3,
        type = RecipeType.Śniadanie,
        image = "https://images.unsplash.com/photo-1587731556938-38755b4803a6?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Mąka", "150 g"),
            Ingredient("Mleko", "200 ml"),
            Ingredient("Jajko", "1 szt."),
            Ingredient("Proszek do pieczenia", "1 łyżeczka")
        ),
        steps = listOf(
            "Wymieszaj składniki na gładkie ciasto.",
            "Smaż małe placuszki na patelni.",
            "Podawaj z syropem klonowym."
        )
    ),
    Recipe(
        id = "18",
        name = "Krewetki w maśle czosnkowym",
        prepTime = 12,
        servings = 2,
        type = RecipeType.Kolacja,
        image = "https://images.unsplash.com/photo-1600891964599-f61ba0e24092?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Krewetki", "250 g"),
            Ingredient("Masło", "2 łyżki"),
            Ingredient("Czosnek", "3 ząbki"),
            Ingredient("Natka pietruszki", "1 łyżka")
        ),
        steps = listOf(
            "Rozpuść masło na patelni.",
            "Dodaj czosnek i chwilę podsmaż.",
            "Wrzuć krewetki i smaż 3–4 minuty.",
            "Posyp pietruszką i podawaj."
        )
    ),
    Recipe(
        id = "19",
        name = "Risotto z pieczarkami",
        prepTime = 35,
        servings = 2,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1603133872878-684f208fb84b?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Ryż arborio", "200 g"),
            Ingredient("Pieczarki", "250 g"),
            Ingredient("Bulion warzywny", "500 ml"),
            Ingredient("Parmezan", "30 g")
        ),
        steps = listOf(
            "Podsmaż pieczarki na maśle.",
            "Dodaj ryż i chwilę podsmaż.",
            "Stopniowo dolewaj bulion, mieszając.",
            "Dodaj parmezan i wymieszaj."
        )
    ),
    Recipe(
        id = "20",
        name = "Kanapka BLT",
        prepTime = 10,
        servings = 1,
        type = RecipeType.Obiad,
        image = "https://images.unsplash.com/photo-1603048297172-c92544798a2c?auto=format&fit=crop&w=1200&q=80",
        ingredients = listOf(
            Ingredient("Bekon", "3 plastry"),
            Ingredient("Sałata", "1 garść"),
            Ingredient("Pomidor", "2 plastry"),
            Ingredient("Pieczywo tostowe", "2 kromki")
        ),
        steps = listOf(
            "Podsmaż bekon na chrupko.",
            "Podpiecz pieczywo.",
            "Ułóż warstwy: sałata, bekon, pomidor.",
            "Złóż kanapkę i podawaj."
        )
    )
)
