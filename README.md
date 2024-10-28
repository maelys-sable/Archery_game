[<img src="https://www.ensicaen.fr/wp-content/uploads/2017/02/LogoEnsicaen.gif" width="256" >](https://www.ensicaen.fr)

Archery
================

## Description du projet

Ce projet est une application graphique développée en Java utilisant la bibliothèque graphique JavaFX. Il met en œuvre un jeu de tir à l'arc et suit le patron d'architecture Modèle-Vue-Présentation (MVP). L'utilisateur doit tirer des flèches sur des cibles, et l'application gère les scores ainsi que différents types d'arcs, chacun ayant des caractéristiques différentes.

Le projet est configuré avec Gradle pour la gestion de la construction.

Le rapport de ce projet ainsi que la soutenance sont disponibles dans le wiki.

## Fonctionnalités

* Simulation de tir à l'arc avec différents types d'arcs offrant des niveaux de précision variés.
* Gestion du score en fonction des cibles atteintes.
* Utilisation du modèle MVP pour une séparation claire entre la logique métier et l'affichage

## Organisation du projet
 
Le projet a la structure suivante :

    .
    ├── build.gradle
    ├── settings.gradle
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   └── fr.ensicaen.ecole.archery
    │   │   │       ├── annotation
    │   │   │       ├── model
    │   │   │       │   ├── bow
    │   │   │       │   ├── player
    │   │   │       │   ├── projectile
    │   │   │       │   ├── space
    │   │   │       │   └── target
    │   │   │       ├── presenter
    │   │   │       └── view
    │   │   └── resources
    │   └── test
    │       └── java
    │           └── fr.ensicaen.ecole.archery
    │               ├── model
    │               └── presenter
    └── web

## Licence
Ce projet est sous licence de l'ENSICAEN. Aucune partie de ce projet ne peut être reproduite, copiée ou modifiée sans l'autorisation de l'institution ou des auteurs.

## Auteurs
* **Maelys Sable** - Cheffe du projet
* **Lucie Chauvet** - Architecte logiciel
* **Mathis Dubuisson** - Architecte logiciel
* **Raquel Maciel-Coelho-De-Sousa** - Responsable GitLab
* **Mohamed-Taha Brida** - Développeur
* **Julien Excoffier** - Développeur
* **Johann Ly** - Développeur

# À vous de jouer !