package KirillNegrobov.ShoppingList.Activities

import KirillNegrobov.ShoppingList.Entities.NoteItem
import KirillNegrobov.ShoppingList.Fragments.NoteFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import KirillNegrobov.ShoppingList.R
import KirillNegrobov.ShoppingList.databinding.ActivityNewNoteBinding
import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.Menu
import android.view.MenuItem
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding
    private var noteItem: NoteItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
        //Проверяем
        getNote()
    }

    //Берем данные из intent которые передали в onClickItem()
    private fun getNote(){
        val sNote = intent.getSerializableExtra(NoteFragment.NEW_NOTE_KEY)
        if (sNote != null){
            noteItem = sNote as NoteItem
            fillNote()
        }

    }
    //Заолняем item если старый
    private fun fillNote() = with(binding) {

        edTitle.setText(noteItem?.title)
        edDescription.setText(noteItem?.content)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nw_note_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.id_save){

            setMainResult()


        }else if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actionBarSettings(){
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setMainResult(){
        var editState = "new"
        val tempNote:NoteItem?
        if (noteItem == null){
            tempNote = createNewNote()
        }else{
            editState = "update"
            tempNote = updateNote()
        }
        val  i = Intent().apply {
            putExtra(NoteFragment.NEW_NOTE_KEY, tempNote)
            putExtra(NoteFragment.EDIT_STATE_KEY,editState)

        }
        setResult(RESULT_OK,i)
        finish()
    }

    private fun updateNote(): NoteItem? = with(binding){
        return noteItem?.copy(title = edTitle.text.toString(),
            content = edDescription.text.toString())

    }

    private fun createNewNote():NoteItem{
        return NoteItem(
            null,
            binding.edTitle.text.toString(),
            binding.edDescription.text.toString(),
            getCurrentTime(),
            "")

    }

    private fun getCurrentTime():String{
        val formater = SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        return formater.format(Calendar.getInstance().time)
    }

}