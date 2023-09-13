package KirillNegrobov.ShoppingList.DB

import KirillNegrobov.ShoppingList.Entities.NoteItem
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    suspend fun insertNote(note: NoteItem)
    @Query("SELECT * FROM note_list")
    fun getAllNote(): Flow<List<NoteItem>>

}