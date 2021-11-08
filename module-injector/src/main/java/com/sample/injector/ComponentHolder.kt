package com.sample.injector

interface ComponentHolder<C : BaseAPI, D : BaseDependencies> {

    //вставляем dependencies в компонент
    fun init(dependencies: D)

    //получаем компонент
    fun get(): C

    //обнуляем компонент
    fun reset()
}
//реализует сторонние core сервисы - например rest api и навигатор
interface BaseDependencies

//реализует методы для FeatureComponent и прочие core Component
interface BaseAPI