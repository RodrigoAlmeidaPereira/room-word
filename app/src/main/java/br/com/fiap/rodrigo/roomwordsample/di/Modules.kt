package br.com.fiap.rodrigo.roomwordsample.di

import androidx.room.Room
import br.com.fiap.rodrigo.roomwordsample.WordListAdapter
import br.com.fiap.rodrigo.roomwordsample.WordViewModel
import br.com.fiap.rodrigo.roomwordsample.dao.WordRoomDatabase
import br.com.fiap.rodrigo.roomwordsample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single{ get<WordRoomDatabase>().wordDao()}
}

val repositoryModule = module {
    single{ WordRepository(get())}
}

val uiModule = module {
    factory { WordListAdapter(get()) }
}

val viewModelModule = module {
    viewModel { WordViewModel(get(), get()) }
}
