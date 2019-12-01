package osahner

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExtensionKtTest {
  private val listVal = listOf("test1", "test2")
  private val listValAsString = """["test1","test2"]"""
  private val mapVal = mapOf("stringProperty" to "theProperty", "numberProperty" to 42)
  private val mapValAsString = """{"stringProperty":"theProperty","numberProperty":42}"""

  @Test
  fun writeValueAsString() {
    listVal.writeValueAsString().also {
      assertNotNull(it)
      assertEquals(listValAsString, it)
    }

    (null as List<String>?).writeValueAsString().also {
      assertNull(it)
    }

    mapVal.writeValueAsString().also {
      assertNotNull(it)
      assertEquals(mapValAsString, it)
    }
  }

  @Test
  fun toStringArray() {
    listValAsString.toStringArray().also {
      assertNotNull(it)
      assertEquals(2, it?.size)
      assertEquals(listVal, it)
    }

    (null as String?).toStringArray().also {
      assertNull(it)
    }

    "this [ is no string array}".toStringArray().also {
      assertNull(it)
    }
  }

  @Test
  fun toMap() {
    mapValAsString.toMap().also {
      assertNotNull(it)
      assertEquals(mapVal, it)
    }

    "this [ is no string map}".toMap().also {
      assertNull(it)
    }

    (null as String?).toMap().also {
      assertNull(it)
    }
  }
}
