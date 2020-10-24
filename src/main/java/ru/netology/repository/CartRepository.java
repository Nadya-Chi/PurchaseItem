package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class CartRepository {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void save(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;

        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public void removeById(int id) {
        PurchaseItem[] tmp = new PurchaseItem[items.length - 1];

        int index = 0;
        for (PurchaseItem item: items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }

        items = tmp;
    }
}
