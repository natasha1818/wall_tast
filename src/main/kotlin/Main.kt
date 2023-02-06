import java.util.IdentityHashMap
import kotlin.random.Random
import kotlin.text.Typography.copyright

data class Post(
    val id: Int,
    var ownerId: Int,        //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int,        //Идентификатор автора записи (от чьего имени опубликована запись)
    val date: String,        //Время публикации записи в формате
    val text: String,      //Текст записи.
    val friendsOnly: Boolean = false,    //если запись была создана с опцией «Только для друзей»
    val canPin: Boolean,    //Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean, //Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean, //Информация о том, может ли текущий пользователь редактировать запись
    val isFavorite: Boolean = true //true, если объект добавлен в закладки у текущего пользователя.
) {}
object WallService {
    var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        val newIdPost = post.copy(id = 1000+1)
        posts += newIdPost
        return posts.last()
    }
//    fun rand(start: Int, end: Int): Int {
//        require(start <= end) { "Illegal Argument" }
//        return Random(System.nanoTime()).nextInt(start, end + 1)
//    }
    fun update(post: Post): Boolean {
        var counter = 0
        for ((index, newIdPost) in posts.withIndex()) {
            if (newIdPost.ownerId == post.ownerId) {
                val newPost = newIdPost.copy(
                    ownerId = post.ownerId,
                    text = post.text,
                    friendsOnly = post.friendsOnly,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isFavorite = post.isFavorite
                )
                posts[index] = newPost
                counter += 10
            }
        }
        if (counter == 0) {
            println(false)
            return false
        } else {
            println(true)
            return true
        }
    }

    fun printPost(ownerId: Int) {
        for ((index, newIdPost) in posts.withIndex()) {
            if (newIdPost.ownerId == ownerId) {
                println(
                    """
      № ${newIdPost.id}
      номер стены ${newIdPost.ownerId}, автор записи ${newIdPost.fromId}
      дата записи: ${newIdPost.date}
     "${newIdPost.text}"
      только для друзей:${newIdPost.friendsOnly}
      закрепить:${newIdPost.canPin}, удалить: ${newIdPost.canDelete}, редактировать: ${newIdPost.canEdit}
      добавить в закладку: ${newIdPost.isFavorite} """.trimIndent()
                )
            }
        }
    }
}


fun main() {
    val post = Post(
        0,
        6835,
        4000,
        "01/02/2023",
        "Домашняя кошка - социальное животное, обладающее развитым интеллектом и способностями к общению, умеющее испытывать и выражать сложные чувства и эмоции.",
        friendsOnly = true,
        false,
        false,
        false,
    )
    val post2 = Post(
        0,
        6987,
        4000,
        "01/02/2023",
        "Размеры тела котов и кошек, в среднем, составляют около 30-60 см в длину и 20-30 см в высоту",
        false,
        false,
        false,
        false,
    )
    val post3 = Post(
        0,
        6565,
        5655,
        "01/02/2023",
        "Кошки являются плотоядными животными, представляя собой мелких хищников. ",
        false,
        false,
        false,
        false,
    )
    val post4 = Post(
        0,
        65699,
        6565,
        "01/02/2023",
        "Кошки являются самыми распространёнными домашними питомцами в мире",
        true,
        true,
        true,
        true,
    )
    val post5 = Post(
        0,
        6565,
        2222,
        "01/02/2023",
        "Ложась на спину, кошки показывают своё доверие к человеку.",
        false,
        true,
        true,
        true,
    )
    WallService.add(post)
    WallService.add(post2)
    WallService.add(post3)
    WallService.printPost(6565)
    WallService.update(post5)
    WallService.update(post4)
    WallService.printPost(65699)
    WallService.printPost(6565)

}
