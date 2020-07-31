public class PeselVal
{


    public boolean PeselValidation(String PESEL)
    {
        byte PESELtab[] = new byte[11];

        if (PESEL.length() != 11)
            return false;
        else
        {
            for(int i=0; i<11; i++)
            {
                PESELtab[i] = Byte.parseByte(PESEL.substring(i, i+1));
            }


            int sum = PESELtab[0] + 3*PESELtab[1] + 7*PESELtab[2] + 9*PESELtab[3] +
                    PESELtab[4] + 3*PESELtab[5] + 7*PESELtab[6] + 9*PESELtab[7]
                    + PESELtab[8] + 3*PESELtab[9];

            int check = sum %10;
            int controlNumber = 10 - check;

            if (controlNumber==PESELtab[10])
                return true;
            else
                return false;

        }
    }

}
