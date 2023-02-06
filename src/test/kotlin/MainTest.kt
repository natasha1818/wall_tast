import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlin.test.assertEquals as testAssertEquals

class MainTest {
@Test
fun updateTrue(){
    val service = WallService

    service.add(Post(6565,4000,1255,"12/01/2023","text",false,false,false,false))
    service.add(Post(6568,4022,1215,"12/01/2023","text",false,false,false,false))
    service.add(Post(6569,4018,1375,"12/01/2023","text",false,false,false,false))

    val update = Post(6222,4000,1255,"22/02/2022","text",true,true,false,false)
    val result = service.update(update)

    assertTrue(result)

}
    @Test
    fun updateFalse(){
        val service = WallService

        service.add(Post(6565,4000,1255,"12/01/2023","text",false,false,false,false))
        service.add(Post(6568,4022,1215,"12/01/2023","text",false,false,false,false))
        service.add(Post(6569,4018,1375,"12/01/2023","text",false,false,false,false))

        val update = Post(6222,1111,1255,"22/02/2022","text",true,true,false,false)
        val result = service.update(update)

        assertFalse(result)

    }
    @Test
    fun addNull(){
        val service = WallService

        service.add(Post(6565,4000,1255,"12/01/2023","text",false,false,false,false))
       val result = service.posts[0].id
       assertEquals(1001,result)
    }

}
