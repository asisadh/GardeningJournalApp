# Gardening Journal App
This app has provides information about the plants such as the plants name, type of plant, watering frequency, and when the plant is planted. All this information is stored in a room database. The plant information is stored in the Plant Entity. All of the plants are accessible from the Gardeling Log feature present in the app. From Log page, we can access all of the plants information and can view them. Also from the add page we can add new plants into our logs. The new plants are stored inside of the same room database.

## Project Structure:

    - java/com/gardeningjournalapp
        - data
            - dao
                PlantDao.kt
            - entity
                Plant.kt
            - repository
                GardeningDatabase.kt
        - domain
            - dto
                PlantDTO.kt
            - repository
                PlantRepository.kt
        - ui
            - adapters
                PlantAdapter.kt
            - fragments
                AddPlantFragment.kt
                BaseFragment.kt
                GardenLogFragment.kt
                HomeFragment.kt
                PlantDetailsFragment.kt
            - viewmodels
                PlantViewModel.kt
                PlantViewModelFactory.kt
            MainActivity.kt
    - res
        - layout
            activity_mail.xml
            fragment_add_plant.xml
            fragment_garden_log.xml
            fragemnt_home.xml
            fragment_plany_details.xml
            item_plany.xml
        - navigation
            nav_graph.xml

## Project Pages:
### Home Page

### Log Page

### Detail Page

## Build and Running the page:
You can simple open the project in the Android Studio. Install all the gardle dependencies and execute the project itself through the Android Studio.

## Implementation Details
In the project structure if you look at the `data` package. This package provides an interface/layer to the room database. Here we have created a layer to store the plant information inside of the Room Database.
In `domain` layer (package). The Plant Entity is transfered to an DTO object and a plant Repository is present to do all the database related queries for the Room Database.
In `UI` layer we are using the view models to fetch the data from database and populate it into the UI. View model executes the fetching calls as coroutines such that main thread is never blocked.

