# Android Clean Architecture

## Introduction
This repository contains Android clean architecture with an MVVM pattern.

## Android Clean Architecture Project Structure
````
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── data/                      # Data layer
│   │   │   │   ├── repository/            # Repositories for data access
│   │   │   │   ├── datasource/            # Data sources (local, remote)
│   │   │   │   ├── model/                 # Data models
│   │   │   │   └── ...
│   │   │   │
│   │   │   ├── domain/                    # Domain layer (business logic)
│   │   │   │   ├── model/                 # Domain models
│   │   │   │   ├── repository/            # Repository interfaces
│   │   │   │   └── usecase/               # Use cases (interactors)
│   │   │   │
│   │   │   ├── presentation/              # Presentation layer (UI)
│   │   │   │   ├── di/                    # Dependency Injection (Dagger, Hilt, Koin, etc.)
│   │   │   │   ├── view/                  # Activities, Fragments, Views
│   │   │   │   ├── viewmodel/             # ViewModels
│   │   │   │   ├── adapter/               # Adapters (RecyclerView, ViewPager, etc.)
│   │   │   │   ├── mapper/                # Mapper classes
│   │   │   │   ├── utils/                 # Utility classes
│   │   │   │   └── ...
│   │   │   │
│   │   │   └── App.kt                    # Application class
│   │   │
│   │   ├── res/                          # Resources
│   │   │   ├── drawable/                 # Drawable resources
│   │   │   ├── layout/                   # Layout XML files
│   │   │   ├── mipmap/                   # Launcher icons
│   │   │   ├── values/                   # Resource values (strings, colors, styles, etc.)
│   │   │   └── ...
│   │   │
│   │   └── AndroidManifest.xml           # Android manifest file
│   │
│   └── test/                             # Unit tests
│       ├── java/
│       │   ├── data/                     # Data layer tests
│       │   ├── domain/                   # Domain layer tests
│       │   └── presentation/             # Presentation layer tests
│       └── ...
│
└── build.gradle                          # Module-level build file
````
