package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartManagerTestNonEmpty {

    @Mock
    private CartRepository repository;

    @InjectMocks
    CartManager manager;

    PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

    @BeforeEach
    public void setUp() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;

        PurchaseItem[] returned = new PurchaseItem[] {second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[] {third, second};

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNoRemoveIfNotExists() {

        int idToRemove = 4;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[] {third, second, first};

        assertArrayEquals(expected, actual);
    }
}
