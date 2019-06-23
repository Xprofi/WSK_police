package ru.petrolplus.wsk_police.common.DataObject

// Содержание 1 элемента
data class ItemListObject (var title: String, var imageId: Int, var typeItem: MenuList, var data: Any? = null, var visibleCheckBox: Boolean = false)

enum class MenuList{
// наименование нашего меню

    CRIMINAL_CASES {
        override fun name() = "Criminal Cases"
    },
    DEPARTMENTS{
        override fun name() = "Departments"
    },
    WANTED{
        override fun name() = "Wanted"
    },
    DETECTIVES{
        override fun name() = "Detectives"
    },
    PHOTO_ROBOT{
        override fun name() = "Photo Robot"
    },
    ABOUT_US{
        override fun name() = "About us"
    },
    LOGOUT{
        override fun name() = "logout"
    };

     internal abstract fun name(): String

}