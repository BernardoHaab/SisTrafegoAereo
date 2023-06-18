package com.trabalhoFinal.SisTrafegoAereo.Utils.Validation;

import java.util.List;

public class ValidaSlots {

    public static boolean valida(List<Integer> slots) {
         List<Integer> sortedSlots =  slots.stream().sorted().toList();
        Integer slotHoraInicio = sortedSlots.get(0);
        Integer slotHoraFim = sortedSlots.get(sortedSlots.size()-1);

        return slotHoraInicio >= 0 && slotHoraFim <= 23;
    }

}
