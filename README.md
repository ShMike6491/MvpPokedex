<h1 align="center">MVP Pokemon App</h1>

<p align="center">  
This is a small network client application based on MVP architecture.
<br>The project is built with intention to exercise on the tech stack & open-source libraries, like: Moxy, Cicerone, Dagger3.
<br>Also fetching data from the network and integrating persisted data in the database via repository pattern.
</p>
</br>

## Project Structure
<p align="center">
<imgsrc="https://drive.google.com/file/d/12KT_-bGHzJWDQ18MR4_7VTFerb-XRNlH/view" alt="App File Structure">
</p>

## Dependencies
- [Kotlin](https://kotlinlang.org/) as the base language.
- [RxJava](http://reactivex.io/) for asynchronous tasks.
- [Dagger](https://dagger.dev/) for dependency injection.
- [Cicerone](https://github.com/terrakok/Cicerone) for the navigation between modules.
- Room Persistence - to construct a database using the abstract layer.
- Architecture
  - MVP Architecture (View - Presenter - Model).
  - [Moxy](https://github.com/moxy-community/Moxy) for implementation of the MVP pattern in an Android Application.
  - Repository pattern.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Glide](https://github.com/bumptech/glide), [GlidePalette](https://github.com/florent37/GlidePalette) - loading images.

## Architecture
![architecture](https://miro.medium.com/max/1024/0*4E8U5YuG22bLp4h8.)

## Open API

<img src="https://user-images.githubusercontent.com/24237865/83422649-d1b1d980-a464-11ea-8c91-a24fdf89cd6b.png" align="right" width="21%"/>

This project is using [PokeApi](https://pokeapi.co/) for constructing RESTful API. 
PokeApi is a full RESTful API linked to an extensive database detailing everything about the Pokémon main game series.
This api coveres everything from Pokémon to Berry Flavors.
