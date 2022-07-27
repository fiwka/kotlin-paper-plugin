package ru.kdev.template.test

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.ServerMock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import ru.kdev.template.TemplatePlugin
import kotlin.properties.Delegates.notNull

class TemplatePluginTest {

    var server: ServerMock by notNull()

    @BeforeEach
    fun setUp() {
        server = MockBukkit.mock()
        MockBukkit.load(TemplatePlugin::class.java)
    }

    @Test
    fun testFlying() {
        assertTrue(server.addPlayer().allowFlight)
        assertTrue(server.addPlayer().isFlying)
    }

    @AfterEach
    fun tearDown() {
        MockBukkit.unmock()
    }
}