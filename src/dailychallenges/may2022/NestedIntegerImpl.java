package dailychallenges.may2022;

import java.util.List;

import static java.util.Objects.nonNull;

public class NestedIntegerImpl implements NestedInteger {

    private final Integer integer;
    private final List<NestedInteger> integerList;

    public NestedIntegerImpl(Integer integer) {
        this.integer = integer;
        this.integerList = null;
    }

    public NestedIntegerImpl(List<NestedInteger> integerList) {
        this.integer = null;
        this.integerList = integerList;
    }

    @Override
    public boolean isInteger() {
        return nonNull(integer);
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return integerList;
    }
}
