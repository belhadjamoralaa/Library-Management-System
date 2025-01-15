Système de Gestion de Bibliothèque
Description
Ce projet est un système de gestion de bibliothèque en Java qui permet de gérer des livres et des membres. Il implémente plusieurs patterns de conception pour une meilleure organisation du code.
Patterns de Conception Utilisés
1. Pattern Observer

Utilisé pour notifier les membres quand de nouveaux livres sont ajoutés
Classes concernées :

Observer.java : Interface pour les observateurs
Subject.java : Interface pour le sujet observé
Les membres sont observateurs de la bibliothèque



2. Pattern Strategy

Utilisé pour gérer différentes stratégies de prix
Classes concernées :

PriceStrategy.java : Interface pour les stratégies de prix
CodeDiscountStrategy.java : Réduction par code
MemberDiscountStrategy.java : Réduction fixe pour membres



3. Pattern Factory

Utilisé pour créer des livres et des membres
Classes concernées :

BookFactory.java : Crée différents types de livres
MemberFactory.java : Crée des membres avec différentes stratégies de réduction



4. Pattern Singleton

Utilisé pour la classe Library
Assure qu'il n'existe qu'une seule instance de la bibliothèque

Structure du Projet
Classes Principales
1. Gestion des Livres

Book.java : Classe abstraite de base pour les livres
PhysicalBook.java : Livre physique avec prix d'emprunt
EBook.java : Livre électronique (gratuit)

2. Gestion des Membres

Member.java : Représente un membre de la bibliothèque

Peut emprunter jusqu'à 5 livres
Reçoit des notifications pour les nouveaux livres
Bénéficie de réductions



3. Gestion de la Bibliothèque

Library.java : Classe principale (Singleton)

Gère les livres et les membres
Notifie les membres des nouveaux livres



4. Interface Utilisateur

LibraryMenu.java : Gestion du menu console
InputManager.java : Gestion des entrées utilisateur

Fonctionnalités

Gestion des Livres

Ajouter des livres (physiques ou électroniques)
Suivre la disponibilité des livres
Afficher la liste des livres


Gestion des Membres

Ajouter des membres
Appliquer des réductions (par code ou fixes)
Afficher la liste des membres


Gestion des Emprunts

Emprunter des livres
Retourner des livres
Calculer les prix avec réductions



Comment Utiliser

Lancer le programme via la classe Main
Utiliser le menu pour :

Ajouter des livres
Ajouter des membres
Gérer les emprunts
Consulter les listes



Points Forts du Système

Gestion flexible des réductions
Notification automatique pour les nouveaux livres
Support de différents types de livres
Interface console simple à utiliser
Structure modulaire et extensible

![image](https://github.com/user-attachments/assets/3b9a564f-c1c0-4ab1-a070-c806060792a4)
![image](https://github.com/user-attachments/assets/6fd1cce7-6785-46b5-aac4-fbd4acb221f5)
![image](https://github.com/user-attachments/assets/eac55582-09bb-4a2e-bd42-1375a7a3655f)






Limitations

Utilisation de tableaux fixes (pas de collections dynamiques)
Nombre maximum de livres : 100
Nombre maximum de membres : 50
Maximum 5 livres empruntés par membre
