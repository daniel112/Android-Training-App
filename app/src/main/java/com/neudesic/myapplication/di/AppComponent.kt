package com.neudesic.myapplication.di
import com.neudesic.myapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

// Definition of a Dagger component
@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {
    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)
}