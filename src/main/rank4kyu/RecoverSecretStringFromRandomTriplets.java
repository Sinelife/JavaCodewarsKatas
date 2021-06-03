package rank4kyu;

import java.util.*;

public class RecoverSecretStringFromRandomTriplets {

    public static void main(String[] args) {
        char[][] triplets = {
                {'t','u','p'},
                {'w','h','i'},
                {'t','s','u'},
                {'a','t','s'},
                {'h','a','p'},
                {'t','i','s'},
                {'w','h','s'}
        };

        char[][] triplets2 = {
                {'g', 'a', 's'},
                {'o', 'g', 's'},
                {'c', 'n', 't'},
                {'c', 'o', 'n'},
                {'a', 't', 's'},
                {'g', 'r', 't'},
                {'r', 't', 's'},
                {'c', 'r', 'a'},
                {'g', 'a', 't'},
                {'n', 'g', 's'},
                {'o', 'a', 's'}
        };

        RecoverSecretStringFromRandomTriplets s = new RecoverSecretStringFromRandomTriplets();
        System.out.println(s.recoverSecret(triplets2));
    }



    public String recoverSecret(char[][] triplets) {
        RelationList list = new RelationList();
        for (char[] triplet : triplets) {
            for (int j = 0; j < triplets[0].length - 1; j++) {
                list.add(new Relation(triplet[j], triplet[j + 1]));
            }
        }
        list.fullNormalize();
        return list.toString();
    }



    class RelationList {
        List<Relation> relations;

        RelationList() {
            relations = new ArrayList<>();
        }

        void add(Relation relation) {
            relations.add(relation);
        }

        private void fullNormalize() {
            for (int i = 0; i < 10; i++) {
                normalizeList();
            }
        }

        private void normalizeList() {
            for (int i = 0; i < relations.size(); i++) {
                List<Relation> list = getAllRelationsWithFirstX(relations.get(i).x);
                for (int j = 0; j < list.size() - 1; j++) {
                    Relation r1 = list.get(j);
                    Relation r2 = list.get(j + 1);
                    cleanList(r1, r2);
                }
            }
        }

        private void cleanList(Relation r1, Relation r2) {
            if (firstYIsBigger(r1, r2)) {
                relations.remove(r2);
            } else if (firstYIsBigger(r2, r1)) {
                relations.remove(r1);
            }
        }

        private boolean firstYIsBigger(Relation r1, Relation r2) {
            Relation r = r1;
            while (hasNext(r)) {
                r = next(r);
                if (r.y == r2.y) {
                    return true;
                }
            }
            return false;
        }

        private Relation next(Relation r) {
            for (Relation relation : relations) {
                if (relation.x == r.y) {
                    return relation;
                }
            }
            return null;
        }

        private boolean hasNext(Relation r) {
            for (Relation relation : relations) {
                if (relation.x == r.y) {
                    return true;
                }
            }
            return false;
        }

        private List<Relation> getAllRelationsWithFirstX(char symbol) {
            List<Relation> list = new ArrayList<>();
            for (Relation relation : relations) {
                if (relation.x == symbol) {
                    list.add(relation);
                }
            }
            return list;
        }


        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            Relation relation = getBiggestRelation();
            while(hasNext(relation)) {
                res.append(relation.x);
                relation = next(relation);
            }
            return res.append(relation.x).append(relation.y).toString();
        }

        private Relation getBiggestRelation() {
            for (int i = 0; i < relations.size(); i++) {
                Relation relation = relations.get(i);
                int counter = 0;
                for (int j = 0; j < relations.size(); j++) {
                    if (relation.x == relations.get(j).y) {
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    return relation;
                }
            }
            return null;
        }



        public String output() {
            String res = "";
            for (Relation relation : relations) {
                res += relation + ", ";
            }
            return res;
        }
    }

    class Relation {
        private Character x;
        private Character y;

        Relation(char x, char y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
