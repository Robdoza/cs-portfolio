from pymongo import MongoClient 
from bson.objectid import ObjectId 

class AnimalShelter(object): 
    """ CRUD operations for Animal collection in MongoDB """ 

    def __init__(self, username, password):
        USER = username
        PASS = password
        HOST = 'localhost'
        PORT = 27017
        DB = 'aac'
        COL = 'animals'
        # 
        # Initialize Connection 
        # 
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT)) 
        self.database = self.client['%s' % (DB)] 
        self.collection = self.database['%s' % (COL)] 

            
    # Method to implement the C in CRUD 
    def create(self, data):
        # Insert a document into the animals collection
        if data is not None: 
            try:
                self.collection.insert_one(data)  # data should be dictionary 
                return True
            except Exception as e:
                print("Error inserting document:", e)
                return False
        else: 
            return False

    # Method to implement the R in CRUD
    def read(self, query):
        # Query documents from the animals collection
        try:
            cursor = self.collection.find(query)
            return list(cursor)
        except Exception as e:
            print("Error reading documents:", e)
            return []
        
    # Method to implement the U in CRUD.
    def update(self, query, new_data):
        # Update documents in the animals collection
        try:
            result = self.collection.update_many(
                query,
                {"$set": new_data}
            )
            return result.modified_count
        except Exception as e:
            print("Error updating documents:", e)
            return 0
        
    # Method to implement the D in CRUD.
    def delete(self, query):
        # Delete documents from the animals collection
        try:
            result = self.collection.delete_many(query)
            return result.deleted_count
        except Exception as e:
            print("Error deleting documents:", e)
            return 0