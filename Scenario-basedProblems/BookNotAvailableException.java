class BookNotAvailableException(Exception):
    def __init__(self, message="Maaf karna, ye book abhi available nahi hai."):
        self.message = message
        super().__init__(self.message)

book_collection = [
    {'title': 'The Lord of the Rings', 'author': 'J.R.R. Tolkien', 'status': 'available'},
    {'title': 'Pride and Prejudice', 'author': 'Jane Austen', 'status': 'available'},
    {'title': '1984', 'author': 'George Orwell', 'status': 'checked out'},
    {'title': 'The Hobbit', 'author': 'J.R.R. Tolkien', 'status': 'available'},
]

def show_all_books():
    print("\n--- Apni Library Collection ---")
    if not book_collection:
        print("Library mein koi bhi book nahi hai.")
        return

    for book in book_collection:
        print(f"Title: {book['title']:<25} | Author: {book['author']:<20} | Status: {book['status']}")
    print("-" * 50)

def find_books(query):
    print(f"\n--- Search kar rahe hain: '{query}' ---")
    
    results = [book for book in book_collection if query.lower() in book['title'].lower()]
    
    if not results:
        print("Koi bhi matching book nahi mili.")
    else:
        for book in results:
            print(f"Title: {book['title']} | Author: {book['author']} | Status: {book['status']}")
            
    return results

def checkout_book(title):
    for book in book_collection:
        if book['title'].lower() == title.lower():
            if book['status'] == 'checked out':
                raise BookNotAvailableException()
            else:
                book['status'] = 'checked out'
                print(f"\n'{book['title']}' successfully checkout ho gayi.")
                return
    
    raise ValueError(f"Error: '{title}' naam ki book library mein hai hi nahi.")

if __name__ == "__main__":
    show_all_books()
    find_books("the")

    try:
        checkout_book('The Lord of the Rings')
    except (BookNotAvailableException, ValueError) as e:
        print(e)
    
    show_all_books()

    try:
        print("\n--- Dobara The Lord of the Rings ko checkout karne ki koshish kar rahe hain ---")
        checkout_book('The Lord of the Rings')
    except BookNotAvailableException as e:
        print(f"Checkout Failed: {e}")
    except ValueError as e:
        print(e)
        
    try:
        print("\n--- Ek aisi book ko checkout karne ki koshish kar rahe hain jo hai hi nahi ---")
        checkout_book('Aisi Koi Book Nahi Hai')
    except ValueError as e:
        print(e)
    
    show_all_books()
