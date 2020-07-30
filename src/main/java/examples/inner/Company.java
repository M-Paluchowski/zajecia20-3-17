package examples.inner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company implements Iterable<String> {

    private List<String> employees = new ArrayList<>();

    public void addEmployee(String employeesName) {
        employees.add(employeesName);
    }

    @Override
    public Iterator<String> iterator() {
        return new CompanyIterator();
    }

    private class CompanyIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return employees.size() > index;
        }

        @Override
        public String next() {
            return employees.get(index++);
        }
    }
}
