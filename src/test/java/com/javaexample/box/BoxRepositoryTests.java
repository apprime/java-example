package com.javaexample.box;

import com.javaexample.data.DatabaseAccess;
import com.javaexample.data.H2DataAccess;
import com.javaexample.infrastructure.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BoxRepositoryTests {

    @InjectMocks
    Repository<Box> repo = new BoxRepository();

    @Mock
    DatabaseAccess dataAccess = new H2DataAccess();

    @Test
    public void createBoxFailsReturnNull(){
        Box testBox = new Box();

        Mockito.when(dataAccess.Db()).thenReturn(dataAccess);
        Mockito.when(dataAccess.Update(anyString(), ArgumentMatchers.any()))
                .thenReturn(false);

        Box result = repo.Create(testBox);

        Assertions.assertNull(result);
    }
}
