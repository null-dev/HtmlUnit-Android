package xyz.nulldev.huandroid;

import android.os.Build;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class ComparatorShim {
    public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        return new NullComparator<>(true, comparator);
    }

    final static class NullComparator<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = -7569533591570686392L;
        private final boolean nullFirst;
        // if null, non-null Ts are considered equal
        private final Comparator<T> real;

        @SuppressWarnings("unchecked")
        NullComparator(boolean nullFirst, Comparator<? super T> real) {
            this.nullFirst = nullFirst;
            this.real = (Comparator<T>) real;
        }

        @Override
        public int compare(T a, T b) {
            if (a == null) {
                return (b == null) ? 0 : (nullFirst ? -1 : 1);
            } else if (b == null) {
                return nullFirst ? 1: -1;
            } else {
                return (real == null) ? 0 : real.compare(a, b);
            }
        }

        @Override
        public Comparator<T> thenComparing(Comparator<? super T> other) {
            Objects.requireNonNull(other);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return new NullComparator<>(nullFirst, (Comparator<? super T>) (real == null ? other : real.thenComparing(other)));
            } else throw new UnsupportedOperationException("This call cannot be made at this API level!");
        }

        @Override
        public Comparator<T> reversed() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                return new NullComparator<>(!nullFirst, real == null ? null : real.reversed());
            } else throw new UnsupportedOperationException("This call cannot be made at this API level!");
        }
    }
}
