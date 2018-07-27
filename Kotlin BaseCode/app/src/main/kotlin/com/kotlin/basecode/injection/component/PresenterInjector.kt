package com.kotlin.basecode.injection.component

import dagger.BindsInstance
import dagger.Component
import com.kotlin.basecode.base.BaseView
import com.kotlin.basecode.injection.module.ContextModule
import com.kotlin.basecode.injection.module.NetworkModule
import com.kotlin.basecode.ui.splashscreen.SplashPresenter
import com.kotlin.basecode.ui.user.UserPresenter
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified Presenter.
     * @param presenter Presenter in which to inject the dependencies
     */
    fun inject(presenter: UserPresenter)
    fun inject(presenter: SplashPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}