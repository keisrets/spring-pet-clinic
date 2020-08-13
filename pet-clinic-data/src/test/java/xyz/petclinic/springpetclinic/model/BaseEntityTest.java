package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    void getId() {
        assertNull(baseEntity.getId());

        baseEntity.setId(1L);
        assertEquals(1L, baseEntity.getId());
    }

    @Test
    void setId() {
        baseEntity.setId(2L);
        assertEquals(2L, baseEntity.getId());
    }

    @Test
    void isNew() {
        assertTrue(baseEntity.isNew());

        baseEntity.setId(3L);
        assertFalse(baseEntity.isNew());
    }
}