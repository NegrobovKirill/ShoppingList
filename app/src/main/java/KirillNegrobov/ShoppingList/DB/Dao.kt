package KirillNegrobov.ShoppingList.DB

import KirillNegrobov.ShoppingList.Entities.NoteItem
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Dao
abstract class Dao {
    @Insert
    abstract fun  insertNote(note: NoteItem)
    @Query("SELECT * FROM note_list")
    abstract fun getAllNote(): Flow<List<NoteItem>>
    @Query("DELETE FROM note_list WHERE id IS :id")
    abstract fun deleteNote(id: Int)
    @Update
    abstract fun updateNote(note: NoteItem)

}