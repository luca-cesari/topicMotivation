# Topic Motivation

A web application that helps users find inspiration for studying by providing related books and movies based on any topic. This tool makes learning more engaging by connecting educational content with popular media.

## Features

- **Smart Recommendations**: Get personalized recommendations of books and movies related to your study topic
- **Multiple Content Types**:
  - Movies from TMDB (The Movie Database)
  - Books from Google Books API
- **Beautiful UI**:
  - Modern and responsive design
  - Visual distinction between books and movies
  - Book covers and movie posters
  - Clean and intuitive interface
- **Rich Information**:
  - Detailed descriptions
  - Author information
  - Direct links to more information
  - Topic-based labels

## Technical Stack

### Backend

- Java 21
- Spring Boot 3.4.3
- RESTful API architecture
- External APIs integration:
  - TMDB API for movies
  - Google Books API for books

### Frontend

- HTML5
- CSS3 with modern styling
- JavaScript (Vanilla)
- Bootstrap 5.3.0
- Font Awesome icons
- Google Fonts (Poppins)

## Usage

1. Enter a topic in the search box (e.g., "science", "history", "philosophy")
2. Click "Get Inspiration" or press Enter
3. Browse through the recommended books and movies
4. Click on "More Information" to learn more about any recommendation

## Features in Detail

### Movie Recommendations

- Fetches movies from TMDB
- Includes movie posters
- Provides plot overviews
- Links to TMDB for more details

### Book Recommendations

- Fetches books from Google Books
- Shows book covers
- Includes author information
- Provides book descriptions
- Links to Google Books or purchase options

### UI Features

- Responsive design that works on all devices
- Visual distinction between books and movies
- Loading indicators
- Error handling
- Alphabetically sorted results
- Beautiful card-based layout

## Acknowledgments

- TMDB API for movie data
- Google Books API for book data
- Bootstrap for the UI framework
- Font Awesome for icons
- Google Fonts for typography
