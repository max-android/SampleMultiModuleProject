package com.sample.injector

interface ComponentHolder<C : BaseAPI, D : BaseDependencies> {

    //вставляем dependencies в компонент
    fun init(dependencies: D)

    //получаем компонент
    fun get(): C

    fun reset()
}
//реализует сторонние core сервисы - сейчас rest api
interface BaseDependencies

//реализует методы для FeatureComponent и прочие core Component
interface BaseAPI