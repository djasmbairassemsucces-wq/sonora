# Sonora — lecteur musique & vidéo pour Android

Application 100 % locale (aucune permission Internet) : Kotlin, Jetpack Compose, Media3 (ExoPlayer + MediaSession), Room.
Compatible Android 8.0 (API 26) à Android 14 (API 34) et plus.

## Compiler l'APK

### Option A — Android Studio
1. Installez Android Studio (version récente) puis `File > Open` et choisissez ce dossier.
2. Si Android Studio demande une distribution Gradle, acceptez qu'il télécharge Gradle 8.7. JDK 17 (inclus).
3. Attendez la synchronisation, puis `Build > Build APK(s)`.
4. L'APK se trouve dans `app/build/outputs/apk/debug/app-debug.apk`. Copiez-le sur le téléphone et installez-le
   (autoriser « sources inconnues »), ou branchez le téléphone en débogage USB et cliquez sur « Run ».

### Option B — sans rien installer (GitHub Actions)
1. Créez un dépôt GitHub vide et envoyez-y tout le contenu de ce dossier (branche `main`).
2. Onglet **Actions** > « Build APK » (se lance tout seul à chaque envoi).
3. Téléchargez l'artefact `sonora-debug-apk` : il contient l'APK installable.

### Ligne de commande
`gradle assembleDebug` (Gradle 8.7, JDK 17, Android SDK 34).

## Fonctionnalités
- Musique : détection automatique (MediaStore), pochettes, titres/artistes/albums, lecture en arrière-plan,
  notification et écran de verrouillage (Media3), suivant/précédent, ±10 s, barre de progression, aléatoire, répétition.
- Vidéo : plein écran paysage, luminosité (glisser à gauche), volume (glisser à droite), double tap ±10 s,
  vitesse 0,5x à 2x, verrouillage des commandes, reprise automatique là où vous vous étiez arrêté.
- Playlists (créer, renommer, supprimer, ajouter/retirer, réordonner), favoris, historique, recherche (sans accents).
- Égaliseur multi-bandes, préréglages Rock/Pop/Jazz/Classique/Hip-Hop, basses renforcées, spatialisation
  (selon le matériel : l'appli l'indique si l'appareil ne la prend pas en charge).
- Paroles : synchronisées (.lrc), intégrées (balise ID3 USLT des MP3), ou import manuel d'un .lrc.
- Thèmes clair/sombre/système, 5 couleurs d'accent, pochettes, écran du lecteur personnalisable.

## Limites connues
- Paroles intégrées : seul le MP3 (balise USLT) est lu. Pour les autres formats, utilisez un fichier .lrc.
- Les formats pris en charge sont ceux d'ExoPlayer/Android (MP3, WAV, AAC, FLAC, OGG, M4A, MP4, MKV, WebM…).
  Certains codecs (ex. AC3/DTS) dépendent de l'appareil.
- L'APK release est signé avec la clé de debug (test uniquement). Pour le Play Store, créez votre propre clé.

## Tests
`gradle test` exécute les tests unitaires de l'analyseur de paroles (LRC).
