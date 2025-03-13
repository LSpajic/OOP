public class Main {
    public static void main(String[] args) {
        JavaProjectFileVisitor visitor = new JavaProjectFileVisitor(Set.of(".pdf"));
        File f = new File("folder1");
        Files.walkFileTree(f.toPath(), visitor);
        Map<String, Set<Path>> map = visitor.getProjectPathsPerExtension();
        for(String key : map.keySet()){
            Set<Path> list = map.get(key);
            for(Path p : list)
                System.out.println("Key: " + key + " - " + p);
        }

    }
}