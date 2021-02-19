# MVVM + Retrofit2 + Java + Recycler View

## Dependencies
### Retrofit
```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
```
### Recycler View
```
implementation 'androidx.recyclerview:recyclerview:1.2.0-beta01'
```
### Glide (to load image)
```
implementation 'com.github.bumptech.glide:glide:4.12.0'
```
### Gson (to convert Json to Plain Old Java Object / POJO)
```
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
```
### Lifecycle for ViewModel
```
implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
```

## Files
### RetroInstance
A singleton for Retrofit
### APIService
Used to store all API calls, such as `@GET`, `@POST`, `@UPDATE`, etc
### MovieModel
This file is the `Plain Old Java Object (POJO)`
### MovieListAdapter
This file is needed for implementing `RecyclerView`

## Demo
<img src="https://user-images.githubusercontent.com/10084360/108469282-d0b41880-723c-11eb-92b6-cb39e348e8db.png" width="350px" height="650px" />
<img src="https://user-images.githubusercontent.com/10084360/108469293-d4e03600-723c-11eb-965d-247f474853cb.png" width="350px" height="650px" />
